package com.kgc.vo;

import java.io.Serializable;

public class Standard implements Serializable{
  private Integer id;
  private String stdnum;
  private String zhname;
  private String version;
  private String keys;
  private String releasedate;
  private String impldate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getStdnum() {
    return stdnum;
  }

  public void setStdnum(String stdnum) {
    this.stdnum = stdnum;
  }

  public String getZhname() {
    return zhname;
  }

  public void setZhname(String zhname) {
    this.zhname = zhname;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getKeys() {
    return keys;
  }

  public void setKeys(String keys) {
    this.keys = keys;
  }

  public String getReleasedate() {
    return releasedate;
  }

  public void setReleasedate(String releasedate) {
    this.releasedate = releasedate;
  }

  public String getImpldate() {
    return impldate;
  }

  public void setImpldate(String impldate) {
    this.impldate = impldate;
  }

  @Override
  public String toString() {
    return "Standard{" +
            "id=" + id +
            ", stdnum='" + stdnum + '\'' +
            ", zhname='" + zhname + '\'' +
            ", version='" + version + '\'' +
            ", keys='" + keys + '\'' +
            ", releasedate='" + releasedate + '\'' +
            ", impldate='" + impldate + '\'' +
            '}';
  }
}
