package com.amila.mycrm.dto;

import com.amila.mycrm.entities.CustomerEntity;

public class CustomerDTO {
  private int id;
  private String name;
  private String department;
  private String address;
  private String mobile;
  private String email;
  private Byte active;
  private Long createdTime;
  private Long updatedTime;

  public CustomerDTO() {
  }

  public CustomerDTO(CustomerEntity customerEntity) {
    this.id = customerEntity.getId();
    this.name = customerEntity.getName();
    this.department = customerEntity.getDepartment();
    this.address = customerEntity.getAddress();
    this.email = customerEntity.getEmail();
    this.active = customerEntity.getActive();
    this.createdTime = customerEntity.getCreatedTime();
    this.updatedTime = customerEntity.getUpdatedTime();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Byte getActive() {
    return active;
  }

  public void setActive(Byte active) {
    this.active = active;
  }

  public Long getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Long createdTime) {
    this.createdTime = createdTime;
  }

  public Long getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Long updatedTime) {
    this.updatedTime = updatedTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CustomerDTO that = (CustomerDTO) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (department != null ? !department.equals(that.department) : that.department != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (active != null ? !active.equals(that.active) : that.active != null) return false;
    if (createdTime != null ? !createdTime.equals(that.createdTime) : that.createdTime != null) return false;
    return updatedTime != null ? updatedTime.equals(that.updatedTime) : that.updatedTime == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (department != null ? department.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (active != null ? active.hashCode() : 0);
    result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
    result = 31 * result + (updatedTime != null ? updatedTime.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CustomerDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", department='" + department + '\'' +
        ", address='" + address + '\'' +
        ", mobile='" + mobile + '\'' +
        ", email='" + email + '\'' +
        ", active=" + active +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        '}';
  }
}
