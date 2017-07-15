public class CountStudentException extends Exception {
    @Override
    public String getMessage() {
        return "Array is full!";
    }
}