package com.amila.mycrm.entities;

import javax.persistence.*;

@Entity
@Table(name = "LOG", schema = "MY_CRM", catalog = "")
public class LogEntity {
  private int id;
  private long timestamp;
  private String operation;
  private String log;

  public LogEntity() {
  }

  public LogEntity(long timestamp, String operation, String log) {
    this.timestamp = timestamp;
    this.operation = operation;
    this.log = log;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "TIMESTAMP")
  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  @Basic
  @Column(name = "OPERATION")
  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  @Basic
  @Column(name = "LOG")
  public String getLog() {
    return log;
  }

  public void setLog(String log) {
    this.log = log;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    LogEntity that = (LogEntity) o;

    if (id != that.id) return false;
    if (timestamp != that.timestamp) return false;
    if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;
    if (log != null ? !log.equals(that.log) : that.log != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
    result = 31 * result + (operation != null ? operation.hashCode() : 0);
    result = 31 * result + (log != null ? log.hashCode() : 0);
    return result;
  }
}
