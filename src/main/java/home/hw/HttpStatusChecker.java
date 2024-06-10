package home.hw;

import home.hw.service.ResourceNotFoundException;

public class HttpStatusChecker {
    private static final String URL_TEMPLATE = HttpRequestCat.PATH_SITE + "/%s.jpg";

    public static String getPathImage(int code) {
        return String.format(URL_TEMPLATE, code);
    }

    public String getStatusImage(int code) throws ResourceNotFoundException {
        String pathImage = getPathImage(code);
        HttpRequestCat httpRequestCat = new HttpRequestCat(pathImage);
        if (httpRequestCat.getResponseCode() == 404
                || httpRequestCat.getResponceStream() == null) {
            throw new ResourceNotFoundException("Image not found");
        }

        return pathImage;
    }

}
