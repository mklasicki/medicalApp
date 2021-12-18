package pl.klasicki.commons;

import org.springframework.stereotype.Component;


public interface Mapper<Dto, Domain> {

    Dto toDto(Domain domain);

    Domain toDomain(Dto dto);

}
