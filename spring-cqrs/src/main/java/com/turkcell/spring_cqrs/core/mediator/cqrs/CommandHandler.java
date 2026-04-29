package com.turkcell.spring_cqrs.core.mediator.cqrs;

// CommandHandler => Command'ları işleyen sınıflar
public interface CommandHandler<C extends Command<R>, R> {
    R handle(C command);
}
