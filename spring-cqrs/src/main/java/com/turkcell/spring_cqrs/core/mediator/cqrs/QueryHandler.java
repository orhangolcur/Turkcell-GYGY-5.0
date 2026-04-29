package com.turkcell.spring_cqrs.core.mediator.cqrs;

// QueryHandler => Query'leri işleyen sınıflar
public interface QueryHandler <Q extends Query<R>, R> {
    R handle(Q query);
}
