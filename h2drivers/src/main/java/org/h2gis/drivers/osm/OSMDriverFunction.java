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
package org.h2gis.drivers.osm;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.h2gis.h2spatialapi.DriverFunction;
import org.h2gis.h2spatialapi.ProgressVisitor;

/**
 *
 * @author Erwan Bocher
 */
public class OSMDriverFunction implements DriverFunction {

    public static String DESCRIPTION = "OSM file (0.6)";
    public static String DESCRIPTION_GZ = "OSM Gzipped file (0.6)";
    public static String DESCRIPTION_BZ2 = "OSM Bzipped file (0.6)";


    @Override
    public IMPORT_DRIVER_TYPE getImportDriverType() {
        return IMPORT_DRIVER_TYPE.COPY;
    }

    @Override
    public String[] getExportFormats() {
        return new String[0];
    }

    @Override
    public String getFormatDescription(String format) {
        if (format.equalsIgnoreCase("osm")) {
            return DESCRIPTION;
        } else if (format.equalsIgnoreCase("gz")) {
            return DESCRIPTION_GZ;
        } else  if (format.equalsIgnoreCase("bz2")) {
            return DESCRIPTION_BZ2;
        } else {
            return "";
        }
    }

    @Override
    public boolean isSpatialFormat(String extension) {
        return extension.equalsIgnoreCase("osm") ||
                extension.equalsIgnoreCase("gz") ||
                extension.equalsIgnoreCase("bz2");
    }

    @Override
    public void exportTable(Connection connection, String tableReference, File fileName, ProgressVisitor progress) throws SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void importFile(Connection connection, String tableReference, File fileName, ProgressVisitor progress) throws SQLException, IOException {
        if(fileName == null || !(fileName.getName().endsWith(".osm") || fileName.getName().endsWith("osm.gz") || fileName.getName().endsWith("osm.bz2"))) {
            throw new IOException(new IllegalArgumentException("This driver handle only osm and osm.gz files"));
        }
        OSMParser osmp = new OSMParser();
        osmp.read(connection, tableReference, fileName, progress);
    }

    @Override
    public String[] getImportFormats() {
        return new String[]{"osm","gz","bz2"};
    }

}