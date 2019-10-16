package com.amila.mycrm.dto;

public class CustomerOperationsDTO {
  private int id;
  private long timestamp;
  private String operation;
  private String log;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

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

    CustomerOperationsDTO that = (CustomerOperationsDTO) o;

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
