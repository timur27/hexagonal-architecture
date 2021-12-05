package com.hexagonal.architecture.core.ports.notifications;


import com.hexagonal.architecture.core.domain.events.EventObject;

public interface NotificationsService {
    void notify(EventObject eventObject);
}