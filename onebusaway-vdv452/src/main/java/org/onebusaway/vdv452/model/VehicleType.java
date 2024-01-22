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
import org.onebusaway.vdv452.serialization.VersionedIdFieldMappingFactory;

@CsvFields(filename = "VEHICLE_TYPE.x10")
public class VehicleType extends IdentityBean<VersionedId> {

  private static final long serialVersionUID = 1L;

  @CsvField(name = "VEHICLE_TYPE", mapping = VersionedIdFieldMappingFactory.class)
  private VersionedId id;

  @CsvField(name = "VH_TYPE_LENGTH")
  private int length;

  @CsvField(name = "VH_TYPE_SEAT")
  private int seatingCapacity;

  @CsvField(name = "VH_TYPE_STAND")
  private int standingCapacity;

  @CsvField(name = "VH_TYPE_SPEC_SEAT")
  private int accessibleCapacity;

  @CsvField(name = "VH_TYPE_DESC")
  private String name;

  @CsvField(name = "VH_TYPE_ABBR")
  private String abreviatedName;

  @Override
  public VersionedId getId() {
    return id;
  }

  @Override
  public void setId(VersionedId id) {
    this.id = id;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getSeatingCapacity() {
    return seatingCapacity;
  }

  public void setSeatingCapacity(int seatingCapacity) {
    this.seatingCapacity = seatingCapacity;
  }

  public int getStandingCapacity() {
    return standingCapacity;
  }

  public void setStandingCapacity(int standingCapacity) {
    this.standingCapacity = standingCapacity;
  }

  public int getAccessibleCapacity() {
    return accessibleCapacity;
  }

  public void setAccessibleCapacity(int accessibleCapacity) {
    this.accessibleCapacity = accessibleCapacity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAbreviatedName() {
    return abreviatedName;
  }

  public void setAbreviatedName(String abreviatedName) {
    this.abreviatedName = abreviatedName;
  }
}
