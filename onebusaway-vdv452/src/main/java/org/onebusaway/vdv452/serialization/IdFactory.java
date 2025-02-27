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
package org.onebusaway.vdv452.serialization;

import java.util.Map;

import org.onebusaway.vdv452.model.EStopType;
import org.onebusaway.vdv452.model.LineId;
import org.onebusaway.vdv452.model.StopId;
import org.onebusaway.vdv452.model.VersionedId;

public class IdFactory {

  public static VersionedId resolveVersionedId(Map<String, Object> csvValues,
      String csvFieldName) {
    String versionString = (String) csvValues.get(VersionedId.BASIS_VERSION_FIELD);
    long version = Long.parseLong(versionString);
    String idString = (String) csvValues.get(csvFieldName);
    long id = Long.parseLong(idString);
    return new VersionedId(version, id);
  }

  public static StopId resolveStopId(Map<String, Object> csvValues,
      String csvFieldName) {
    String versionString = (String) csvValues.get(VersionedId.BASIS_VERSION_FIELD);
    long version = Long.parseLong(versionString);
    String typeString = (String) csvValues.get(getStopTypeFieldName(csvFieldName));
    EStopType type = EStopType.parseFieldValue(typeString);
    String idString = (String) csvValues.get(csvFieldName);
    long id = Long.parseLong(idString);
    return new StopId(version, type, id);
  }

  public static LineId resolveLineId(Map<String, Object> csvValues,
      String csvFieldName) {
    String versionString = (String) csvValues.get(VersionedId.BASIS_VERSION_FIELD);
    long version = Long.parseLong(versionString);
    String lineIdString = (String) csvValues.get("LINE_NO");
    long lineId = Long.parseLong(lineIdString);
    String lineVariation = (String) csvValues.get("ROUTE_ABBR");
    return new LineId(version, lineId, lineVariation);
  }

  private static String getStopTypeFieldName(String csvFieldName) {
    if (csvFieldName.equals("POINT_NO")) {
      return "POINT_TYPE";
    } else if (csvFieldName.equals("TO_POINT_NO")) {
      return "TO_POINT_TYPE";
    } else if (csvFieldName.equals("FROM_POINT_NO")) {
      return "FROM_POINT_TYPE";
    } else if (csvFieldName.equals("TO_POINT_NO")) {
      return "TO_POINT_TYPE";
    }
    throw new IllegalStateException("Unknown stop point id field: "
        + csvFieldName);
  }

}
