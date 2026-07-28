package com.example.hexagonal_completed_design.order.adapter.out.persistance.jpa;

import com.example.hexagonal_completed_design.order.adapter.out.persistance.entity.OrderEntity;
import com.example.hexagonal_completed_design.order.adapter.out.persistance.mapper.OrderMapper;
import com.example.hexagonal_completed_design.order.domain.aggregate.Order;
import com.example.hexagonal_completed_design.order.domain.repository.OrderRepository;
import com.example.hexagonal_completed_design.order.domain.valueobject.OrderId;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary // Indique à Spring d'utiliser cette implémentation JPA plutôt que la version en mémoire
public class JpaOrderPersistenceAdapter implements OrderRepository {

    private final SpringDataOrderRepository repository;

    public JpaOrderPersistenceAdapter(SpringDataOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Order order) {
        // 1. Convertir le Domaine pur en Entité JPA
        OrderEntity entity = OrderMapper.toEntity(order);
        // 2. Sauvegarder en base H2 via Spring Data
        repository.save(entity);
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        // 1. Chercher l'entité JPA
        // 2. Convertir l'Entité JPA en Domaine pur
        return repository.findById(id.value())
                .map(OrderMapper::toDomain);
    }
}