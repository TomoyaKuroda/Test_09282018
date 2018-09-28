package test;

/**
 *
 * @author Tomoya
 */
public final class Sign {

    private int height, width;
    private String message;

    public Sign(int height, int width, String message) {
        setHeight(height);
        setWidth(width);
        setMessage(message);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height >= 10 && height <= 100) {

            this.height = height;
        } else {
            throw new IllegalArgumentException("Height should be in the range 10-100");
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width >= 10 && width <= 500) {

            this.width = width;
        } else {
            throw new IllegalArgumentException("Width should be in the range 10-500");
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (!message.isEmpty()) {
            this.message = message;
        } else {
            throw new IllegalArgumentException("The message cannot be empty");
        }
    }

    @Override
    public String toString() {
        return String.format("%s wide x %s high\nmessage: '%s'", width, height, message);
    }
}
