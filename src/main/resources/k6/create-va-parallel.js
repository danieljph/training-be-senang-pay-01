// noinspection DuplicatedCode,JSUrlImportUsage,JSFileReferences

/**
 * @author Daniel Joi Partogi Hutapea
 */

import { check } from 'k6';
import http from 'k6/http';

// This init line we'll be called for each VU's iteration. Be careful.
const showRequestLog = (__ENV.showRequestLog || 'false') === 'true';

const numberOfRequiredData = __ENV.numberOfRequiredData || 10;

const baseUrl = __ENV.baseUrl || 'http://localhost:8080';
const createVaUrl = __ENV.createVaUrl || `${baseUrl}/training-be-senang-pay-01/register/transfer-va/create-va`;

const merchantPartnerId = __ENV.merchantPartnerId || 'merchant-1';

export const options = {
    setupTimeout: '60m', // Default value is 60s.
    summaryTrendStats: ['avg', 'min', 'med', 'max', 'p(90)', 'p(95)', 'p(99.50)'],
    thresholds: {
        'http_req_duration{stage:vu-code}': ['p(95)<=2000'],
        'http_req_failed{stage:vu-code}': ['rate<0.02'],
        'http_reqs{stage:vu-code}': ['rate>200']
    },
    scenarios: {
        //ramping_vus_scenario: {
        //    executor: 'ramping-vus',
        //    startVUs: 0, // Default value is 1.
        //    stages: [
        //        { duration: '30s', target: 50 },
        //        { duration: '60s', target: 100 },
        //        { duration: '60s', target: 100 },
        //        { duration: '30s', target: 0 }
        //    ],
        //    gracefulRampDown: '30s', // Default value is 30s.
        //},
        shared_iter_scenario: {
            executor: 'shared-iterations',
            vus: 3,
            iterations: numberOfRequiredData,
            startTime: '0s',
            maxDuration: '60m'
        }
    }
};

const createVa = () => {
    const apiName = 'Create-VA';

    if(showRequestLog) {
        console.log(`===== API ${apiName} Start =====`);
    }

    const unixEpoch = Math.floor(Date.now() / 1000);
    const invoiceNo = `INV_${unixEpoch}`;

    const url = createVaUrl;
    const payload =
`{
    "invoiceNumber": "${invoiceNo}",
    "virtualAccountNo": "${unixEpoch}",
    "virtualAccountName": "C_${unixEpoch}",
    "virtualAccountEmail": "test.merchant.${unixEpoch}@test.com",
    "virtualAccountPhone": "628${unixEpoch}",
    "amount": {
        "value": "12500.00",
        "currency": "IDR"
    },
    "additionalInfo": {
        "info1FromMerchantCreateVa": "Info 1 from Merchant Create VA"
    }
}`;

    const params = {
        headers: {
            'Content-Type': 'application/json',
            'X-PARTNER-ID': `${merchantPartnerId}`
        }
    };

    if(showRequestLog) {
        console.log(`API ${apiName} - Request-Headers:\n`, JSON.stringify(params.headers, null, 2));
        console.log(`API ${apiName} - Request-Body:\n`, payload);
    }

    const res = http.post(url, payload, params);

    if(showRequestLog) {
        console.log(`API ${apiName} - Response-Body:\n`, res.body);
    }

    const responseCode = res.json('responseCode');
    const responseMessage = res.json('responseMessage');

    if(responseCode !== '200XX00') {
        console.log(`${invoiceNo} - ${responseCode} - ${responseMessage}`);
    }

    check(res, {
        'status is 200': (r) => r.status === 200
    });

    if(showRequestLog) {
        console.log(`----- API ${apiName} DONE -----`);
        console.log();
    }

    return {responseCode, responseMessage};
}

export function setup() {
}

// noinspection JSUnusedGlobalSymbols
export default function (setupData) {
    createVa();
}

export function teardown(setupData) {
}
