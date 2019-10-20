package com.amila.mycrm.dto;

public class GridSettingsDTO {

  private Integer jtStartIndex;
  private Integer jtPageSize;
  private String jtSorting;

  public Integer getJtStartIndex() {
    return jtStartIndex;
  }

  public void setJtStartIndex(Integer jtStartIndex) {
    this.jtStartIndex = jtStartIndex;
  }

  public Integer getJtPageSize() {
    return jtPageSize;
  }

  public void setJtPageSize(Integer jtPageSize) {
    this.jtPageSize = jtPageSize;
  }

  public String getJtSorting() {
    return jtSorting;
  }

  public void setJtSorting(String jtSorting) {
    this.jtSorting = jtSorting;
  }

  @Override
  public String toString() {
    return "GridSettingsDTO{" +
        "jtStartIndex=" + jtStartIndex +
        ", jtPageSize=" + jtPageSize +
        ", jtSorting='" + jtSorting + '\'' +
        '}';
  }
}
