package mk.ukim.finki.emt.lab.infra.eventlog;

import mk.ukim.finki.emt.lab.domain.base.IdentifiableDomainObject;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public class DomainEventLog implements IdentifiableDomainObject<DomainEventLogId> {

    private final DomainEventLogId id;
    private final DomainEventLogId previous;
    private final DomainEventLogId next;
    private final List<StoredDomainEvent> events;

    DomainEventLog(@NonNull DomainEventLogId id, @Nullable DomainEventLogId previous,
                   @Nullable DomainEventLogId next, @NonNull List<StoredDomainEvent> events) {
        this.id = id;
        this.previous = previous;
        this.next = next;
        this.events = List.copyOf(events);
    }

    @Override
    @NonNull
    public DomainEventLogId id() {
        return id;
    }

    @NonNull
    public Optional<DomainEventLogId> previousId() {
        return Optional.ofNullable(previous);
    }

    @NonNull
    public Optional<DomainEventLogId> nextId() {
        return Optional.ofNullable(next);
    }

    @NonNull
    public List<StoredDomainEvent> events() {
        return events;
    }
}
