package com.studensJournal.entities.registration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.studensJournal.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_avatars")
public class Avatar  extends BaseEntity {

  @JsonIgnore
  @Column(name = "user_id")
  private long userId;

  @Lob
  private String avatar;

}