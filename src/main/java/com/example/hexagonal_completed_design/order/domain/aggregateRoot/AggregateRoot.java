package com.example.hexagonal_completed_design.order.domain.aggregateRoot;

import com.example.hexagonal_completed_design.order.domain.domainEvent.DomainEvent;
import com.example.hexagonal_completed_design.order.domain.identifier.Identifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AggregateRoot<ID extends Identifier<?>> {
    private final ID id;
    private final List<DomainEvent> domainEvents = new ArrayList<>();

    protected AggregateRoot(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    protected void registerEvent(DomainEvent event) {
        this.domainEvents.add(event);
    }

    public void clearDomainEvents() {
        this.domainEvents.clear();
    }

    public List<DomainEvent> getDomainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }
}