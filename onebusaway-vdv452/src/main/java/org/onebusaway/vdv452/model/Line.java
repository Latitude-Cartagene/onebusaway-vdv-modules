/**
 * Copyright (C) 2013 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.vdv452.model;

import org.onebusaway.csv_entities.schema.annotations.CsvField;
import org.onebusaway.csv_entities.schema.annotations.CsvFields;
import org.onebusaway.vdv452.serialization.LineIdFieldMappingFactory;

@CsvFields(filename = "LINE.x10")
public class Line extends IdentityBean<LineId> {

  private static final long serialVersionUID = 1L;

  @CsvField(name = "LINE_NO", mapping = LineIdFieldMappingFactory.class)
  private LineId id;

  @CsvField(name = "LINE_ABBR")
  private String shortName;

  @CsvField(name = "LINE_DESC", optional = true)
  private String longName;

  @CsvField(name = "DIRECTION", optional = true)
  private int direction;

  @Override
  public LineId getId() {
    return id;
  }

  @Override
  public void setId(LineId id) {
    this.id = id;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getLongName() {
    return longName;
  }

  public void setLongName(String longName) {
    this.longName = longName;
  }

  public int getDirection() {
    return direction;
  }

  public void setDirection(int direction) {
    this.direction = direction;
  }
}
