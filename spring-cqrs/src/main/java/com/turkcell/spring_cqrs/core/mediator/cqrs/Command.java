package com.turkcell.spring_cqrs.core.mediator.cqrs;

// Command => Değişiklik yapacak işlemler (Create, Update, Delete)
public interface Command<R> {} // R => Dönüş tipi (dinamik)
