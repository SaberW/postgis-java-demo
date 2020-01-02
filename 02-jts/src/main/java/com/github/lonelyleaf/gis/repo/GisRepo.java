/*
 * Copyright [2020] [lonelyleaf]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.lonelyleaf.gis.repo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.locationtech.jts.geom.Geometry;

/**
 * 详细内容请参考
 *
 * https://postgis.net/docs/manual-dev/reference.html
 */
@Mapper
public interface GisRepo {

    @Select("select ST_Distance(#{a},#{b})")
    double stDistance(@Param("a") Geometry a, @Param("b") Geometry b);

    @Select("select ST_Distance(#{a}::geography,#{b}::geography)")
    double stDistanceGeography(@Param("a") Geometry a, @Param("b") Geometry b);

    /**
     * https://postgis.net/docs/ST_DistanceSphere.html
     */
    @Select("select ST_DistanceSphere(#{a},#{b})")
    double stDistanceSphere(@Param("a") Geometry a, @Param("b") Geometry b);

}