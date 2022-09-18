/*----------------------------------------------------------------
	FILE		: CSDArrayList.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 18.09.2022

	CSDArrayList class that represents dynamic array

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.collection;

import java.util.*;

public class CSDArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E [] m_elems;
    private int m_index;

    private static void doWorkForIllegalArgumentException(String message)
    {
        throw new IllegalArgumentException(message);
    }

    private static void doWorkForIndexOutOfBoundsException(String message)
    {
        throw new IndexOutOfBoundsException(message);
    }

    private static void checkCapacity(int capacity)
    {
        if (capacity < 0)
            doWorkForIllegalArgumentException("Capacity value can not be negative:" + capacity);
    }

    private void checkIndex(int index)
    {
        if (index < 0 || m_index <= index)
            doWorkForIndexOutOfBoundsException("Index out of range:" + index);
    }

    private void changeCapacity(int capacity)
    {
        m_elems = Arrays.copyOf(m_elems, capacity);
    }

    @SuppressWarnings("unchecked")
    public CSDArrayList()
    {
        m_elems = (E[])new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public CSDArrayList(int initialCapacity)
    {
        checkCapacity(initialCapacity);
        m_elems = (E [])new Object[initialCapacity];
    }

    public CSDArrayList(Collection<? extends E> collection)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public boolean add(E elem)
    {
        if (m_elems.length == m_index)
            changeCapacity(m_elems.length == 0 ? 1 : m_elems.length * 2);

        m_elems[m_index++] = elem;

        return true;
    }

    public void add(int index, E elem)
    {
        if (m_elems.length == m_index)
            changeCapacity(m_elems.length == 0 ? 1 : m_elems.length * 2);

        for (int i = m_index++; i > index; --i)
            m_elems[i] = m_elems[i - 1];

        m_elems[index] = elem;
    }

    public int capacity()
    {
        return m_elems.length;
    }

    public void clear()
    {
        for (int i = 0; i < m_index; ++i)
            m_elems[i] = null;

        m_index = 0;
    }

    public void ensureCapacity(int minCapacity)
    {
        if (minCapacity > m_elems.length)
            changeCapacity(Math.max(m_elems.length * 2, minCapacity));
    }

    public E get(int index)
    {
        checkIndex(index);

        return m_elems[index];
    }

    public boolean isEmpty()
    {
        return m_index == 0;
    }

    public E set(int index, E elem)
    {
        checkIndex(index);
        E old = m_elems[index];

        m_elems[index] = elem;

        return old;
    }

    public int size()
    {
        return m_index;
    }

    public E remove(int index)
    {
        checkIndex(index);
        E old = m_elems[index];

        for (int i = index; i < m_index - 1; ++i)
            m_elems[i] = m_elems[i + 1];

        m_elems[--m_index] = null;

        return old;
    }

    public void trimToSize()
    {
        if (m_elems.length != m_index)
            changeCapacity(m_index);
    }

    public String toString()
    {
        var sb = new StringBuilder("[");

        for (int i = 0; i < m_index; ++i) {
            if (sb.length() != 1)
                sb.append(", ");
            sb.append(m_elems[i]);
        }

        return sb.append("]").toString();
    }

    /////////////////////////////////////////////////////////////

    @Override
    public boolean contains(Object o)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Iterator<E> iterator()
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Object[] toArray()
    {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean remove(Object o)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("TODO");
    }


    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("No supported");
    }

    @Override
    public int indexOf(Object o)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int lastIndexOf(Object o)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public ListIterator<E> listIterator()
    {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public ListIterator<E> listIterator(int index)
    {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException("Not supported");
    }
}