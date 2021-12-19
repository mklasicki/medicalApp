package pl.klasicki.commons;


public interface Mapper<Dto, Domain> {

    Dto toDto(Domain domain);

    Domain toDomain(Dto dto);

}
