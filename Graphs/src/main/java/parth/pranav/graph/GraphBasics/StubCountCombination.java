package parth.pranav.graph.GraphBasics;

import java.util.UUID;

public class StubCountCombination {
    private UUID id;
    private Integer count;

    public StubCountCombination(UUID a, Integer b) {
        this.id = a;
        this.count = b;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
