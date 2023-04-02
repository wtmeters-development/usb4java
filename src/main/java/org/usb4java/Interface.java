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
 * A collection of alternate settings for a particular USB interface.
 *
 * @author Klaus Reimer (k@ailis.de)
 */
@EqualsAndHashCode(doNotUseGetters = true)
public final class Interface
{
    /** The native pointer to the descriptor structure. */
    private long interfacePointer;

    /**
     * Package-private constructor to prevent manual instantiation. Interfaces
     * are always created by JNI.
     */
    Interface()
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
        return this.interfacePointer;
    }

    /**
     * Returns the array with interface descriptors. The length of this array is
     * determined by the {@link #numAltsetting()} field.
     *
     * @return The array with interface descriptors.
     */
    public native InterfaceDescriptor[] altsetting();

    /**
     * Returns the number of alternate settings that belong to this interface.
     *
     * @return The number of alternate settings.
     */
    public native int numAltsetting();

    /**
     * Returns a dump of this interface.
     *
     * @return The interface dump.
     */
    public @NotNull String dump()
    {
        final StringBuilder builder = new StringBuilder();

        builder.append(String.format(
            "Interface:%n" +
            "  numAltsetting %10d",
            this.numAltsetting()));

        for (final InterfaceDescriptor intDesc : this.altsetting())
        {
            builder.append(String.format("%n")).append(intDesc.dump());
        }

        return builder.toString();
    }

    @Override
    public @NotNull String toString()
    {
        return this.dump();
    }
}
