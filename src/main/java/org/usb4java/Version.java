/*
 * Copyright 2013 Klaus Reimer <k@ailis.de>
 * See LICENSE.md for licensing information.
 *
 * Based on libusb <http://libusb.info/>:
 *
 * Copyright 2001 Johannes Erdfelt <johannes@erdfelt.com>
 * Copyright 2007-2009 Daniel Drake <dsd@gentoo.org>
 * Copyright 2010-2012 Peter Stuge <peter@stuge.se>
 * Copyright 2008-2013 Nathan Hjelm <hjelmn@users.sourceforge.net>
 * Copyright 2009-2013 Pete Batard <pete@akeo.ie>
 * Copyright 2009-2013 Ludovic Rousseau <ludovic.rousseau@gmail.com>
 * Copyright 2010-2012 Michael Plante <michael.plante@gmail.com>
 * Copyright 2011-2013 Hans de Goede <hdegoede@redhat.com>
 * Copyright 2012-2013 Martin Pieuchot <mpi@openbsd.org>
 * Copyright 2012-2013 Toby Gray <toby.gray@realvnc.com>
 */

package org.usb4java;

import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

/**
 * Structure providing the version of the libusb runtime.
 *
 * @author Klaus Reimer (k@ailis.de)
 */
@EqualsAndHashCode(doNotUseGetters = true)
public final class Version
{
    /** The native pointer to the version structure. */
    private long versionPointer;

    /**
     * Package-private constructor to prevent manual instantiation. An instance
     * is only returned by the JNI method {@link LibUsb#getVersion()}.
     */
    Version()
    {
        // Empty
    }

    /**
     * Returns the native pointer.
     *
     * @return The native pointer.
     */
    public long getPointer()
    {
        return this.versionPointer;
    }

    /**
     * Returns the library major version.
     *
     * @return The library major version.
     */
    public native int major();

    /**
     * Returns the library minor version.
     *
     * @return The library minor version.
     */
    public native int minor();

    /**
     * Returns the library micro version.
     *
     * @return The library micro version.
     */
    public native int micro();

    /**
     * Returns the library nano version.
     *
     * @return The library nano version.
     */
    public native int nano();

    /**
     * Returns the release candidate suffix string, e.g. "-rc4".
     *
     * @return The release candidate suffix string.
     */
    public native String rc();

    @Override
    public @NotNull String toString()
    {
        return this.major() + "." + this.minor() + "." + this.micro() + "."
            + this.nano() + this.rc();
    }
}
