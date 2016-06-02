/**
 * H2GIS is a library that brings spatial support to the H2 Database Engine
 * <http://www.h2database.com>. H2GIS is developed by CNRS
 * <http://www.cnrs.fr/>.
 *
 * This code is part of the H2GIS project. H2GIS is free software; 
 * you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation;
 * version 3.0 of the License.
 *
 * H2GIS is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details <http://www.gnu.org/licenses/>.
 *
 *
 * For more information, please consult: <http://www.h2gis.org/>
 * or contact directly: info_at_h2gis.org
 */

package org.h2gis.functions.spatial.predicates;

import com.vividsolutions.jts.geom.Geometry;
import org.h2gis.api.DeterministicScalarFunction;

/**
 * Return true if Geometry A is equal to Geometry B.
 *
 * @author Nicolas Fortin
 */
public class ST_Equals extends DeterministicScalarFunction {

    /**
     * Default constructor
     */
    public ST_Equals() {
        addProperty(PROP_REMARKS, "Return true if Geometry A is equal to Geometry B");
    }
    @Override
    public String getJavaStaticMethod() {
        return "geomEquals";
    }

    /**
     * Return true if Geometry A is equal to Geometry B
     *
     * @param a Geometry Geometry.
     * @param b Geometry instance
     * @return true if Geometry A is equal to Geometry B
     */
    public static Boolean geomEquals(Geometry a, Geometry b) {
        if(a==null || b==null) {
            return null;
        }
        return a.equals(b);
    }
}