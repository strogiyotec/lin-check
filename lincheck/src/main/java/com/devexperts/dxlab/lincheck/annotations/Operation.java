package com.devexperts.dxlab.lincheck.annotations;

/*
 * #%L
 * Lincheck
 * %%
 * Copyright (C) 2015 - 2018 Devexperts, LLC
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mark your method with this annotation in order
 * to use it in concurrent testing as an operation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Operation {
    /**
     * Binds the arguments of this operations with the specified {@link Param parameter configurations}
     * by theirs {@link Param#name()} names
     */
    String[] params() default {};

    /**
     * Set it to {@code true} if you this operation should be called
     * at most once during the test invocation; {@code false} by default.
     */
    boolean runOnce() default false;

    /**
     * Specifies the operation group which can add some execution restriction.
     * @see OpGroupConfig#name()
     */
    String group() default "";

    /**
     * Handle the specified exceptions as a result of this operation invocation.
     */
    Class<? extends Throwable>[] handleExceptionsAsResult() default {};
}
