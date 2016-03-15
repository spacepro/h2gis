/**
 * H2GIS is a library that brings spatial support to the H2 Database Engine
 * <http://www.h2database.com>.
 *
 * H2GIS is distributed under GPL 3 license. It is produced by CNRS
 * <http://www.cnrs.fr/>.
 *
 * H2GIS is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * H2GIS is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * H2GIS. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.h2gis.org/>
 * or contact directly: info_at_h2gis.org
 */

package org.h2gis.h2spatialext.function.spatial.properties;

import com.vividsolutions.jts.geom.Geometry;
import org.h2gis.h2spatialapi.DeterministicScalarFunction;
import static org.h2gis.h2spatialapi.Function.PROP_REMARKS;

/**
 *
 * @author Erwan Bocher
 */
public class ST_NPoints extends DeterministicScalarFunction {

    /**
     * Default constructor
     */
    public ST_NPoints() {
        addProperty(PROP_REMARKS, "Return the number of points (vertexes) in a geometry.");
    }

    @Override
    public String getJavaStaticMethod() {
        return "getNPoints";
    }

    /**
     * @param geometry Geometry instance or null
     * @return Number of points or null if Geometry is null.
     */
    public static Integer getNPoints(Geometry geometry) {
        if(geometry==null) {
            return null;
        }
        return geometry.getNumPoints();
    }
    
}
