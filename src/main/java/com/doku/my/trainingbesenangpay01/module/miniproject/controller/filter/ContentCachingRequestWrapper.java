package com.doku.my.trainingbesenangpay01.module.miniproject.controller.filter;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.util.StreamUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Slf4j
public class ContentCachingRequestWrapper extends HttpServletRequestWrapper
{
    private final byte[] cachedBody;

    public ContentCachingRequestWrapper(HttpServletRequest request) throws IOException
    {
        super(request);
        var requestInputStream = request.getInputStream();
        this.cachedBody = StreamUtils.copyToByteArray(requestInputStream);
    }

    @Override
    public ServletInputStream getInputStream()
    {
        return new CachedServletInputStream(getContentAsByteArray());
    }

    @Override
    public BufferedReader getReader()
    {
        var byteArrayInputStream = new ByteArrayInputStream(getContentAsByteArray());
        return new BufferedReader(new InputStreamReader(byteArrayInputStream));
    }

    public byte[] getContentAsByteArray()
    {
        return cachedBody;
    }

    @SuppressWarnings("unused")
    public String getContentAsString() throws IOException
    {
        return IOUtils.toString(getInputStream(), getCharacterEncoding());
    }

    public static class CachedServletInputStream extends ServletInputStream
    {
        private final InputStream cachedBodyInputStream;

        public CachedServletInputStream(byte[] cachedBody)
        {
            this.cachedBodyInputStream = new ByteArrayInputStream(cachedBody);
        }

        @Override
        public boolean isFinished()
        {
            try
            {
                return cachedBodyInputStream.available() == 0;
            }
            catch(IOException ex)
            {
                log.error("Failed on isFinished.", ex);
            }
            return false;
        }

        @Override
        public boolean isReady()
        {
            return true;
        }

        @Override
        public void setReadListener(ReadListener readListener)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public int read() throws IOException
        {
            return cachedBodyInputStream.read();
        }
    }
}
