/*******************************************************************************
 * This file is part of the Technical Infrastructure Monitoring (TIM) project.
 * See http://ts-project-tim.web.cern.ch
 *
 * Copyright (C) 2004 - 2015 CERN. This program is free software; you can
 * redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version. This program is distributed
 * in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program; if not,
 * write to the Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * Author: TIM team, tim.support@cern.ch
 ******************************************************************************/
package cern.modesti.repository.mongo.request.counter;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Justin Lewis Salmon
 */
@Document(collection = "counters")
public class Counter {

  @Id
  private String id;

  private Long sequence;

  /**
   *
   */
  public Counter(String id, Long sequence) {
    this.id = id;
    this.sequence = sequence;
  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @return the sequence
   */
  public Long getSequence() {
    return sequence;
  }

  /**
   * @param sequence the sequence to set
   */
  public void setSequence(Long sequence) {
    this.sequence = sequence;
  }
}