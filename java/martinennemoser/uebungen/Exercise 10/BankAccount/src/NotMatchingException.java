public class NotMatchingException extends Exception {
    public NotMatchingException(String msg) {
        super(msg);
        System.out.println(msg);
    }
}
