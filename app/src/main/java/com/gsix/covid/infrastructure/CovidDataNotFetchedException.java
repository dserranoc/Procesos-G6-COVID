package infrastructure;

public class CovidDataNotFetchedException extends RuntimeException {

    public CovidDataNotFetchedException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }

}
