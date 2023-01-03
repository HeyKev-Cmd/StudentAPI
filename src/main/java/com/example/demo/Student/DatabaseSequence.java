package com.example.demo.Student;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.persistence.Id;

@Document(collection = "database_sequences")
public class DatabaseSequence {
    @Id
    private String id;
    private long seq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }


}
