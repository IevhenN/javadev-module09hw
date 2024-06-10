package home.hw;

import home.hw.service.ResourceNotFoundException;
import home.hw.service.Writer;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws ResourceNotFoundException {
        String path = new HttpStatusChecker().getStatusImage(code);

        if (path == null) {
            throw new ResourceNotFoundException();
        }

        HttpRequestCat httpRequestCat = new HttpRequestCat(HttpStatusChecker.getPathImage(code));

        new Writer().saveImage(code, httpRequestCat.getResponceStream());
    }
}
