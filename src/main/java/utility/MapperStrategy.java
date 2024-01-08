package utility;

public interface MapperStrategy<T, R> {

    R mapToDto(T entity);

    T mapToModel(R dto);
}
