/*
 * Copyright (c) 2020 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.petkata;

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * In the slides leading up to this exercise you should have learned about the following APIs.
 * <p/>
 * {@link MutableList#collect(Function)}<br>
 * {@link MutableList#select(Predicate)}<br>
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/pet-kata/#/2">Exercise 1 Slides</a>
 */
public class Exercise1Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    public void getFirstNamesOfAllPeople()
    {
        // Replace null, with a transformation method on MutableList.
        MutableList<String> firstNames = this.people.collect(Person::getFirstName); // this.people...

        var expectedFirstNames = Lists.mutable.with("Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John");
        Assertions.assertEquals(expectedFirstNames, firstNames);
    }

    @Test
    @Tag("KATA")
    public void getNamesOfMarySmithsPets()
    {
        Person person = this.getPersonNamed("Mary Smith");
        MutableList<Pet> pets = person.getPets();

        // Replace null, with a transformation method on MutableList.
        MutableList<String> names = pets.collect(Pet::getName); // pets...

        Assertions.assertEquals("Tabby", names.makeString());
    }

    @Test
    @Tag("KATA")
    public void getPeopleWithCats()
    {
        // Replace null, with a positive filtering method on MutableList.
        MutableList<Person> peopleWithCats = this.people.selectWith(Person::hasPet, PetType.CAT);  // this.people...

        Verify.assertSize(2, peopleWithCats);
    }

    @Test
    @Tag("KATA")
    public void getPeopleWithoutCats()
    {
        // Replace null, with a negative filtering method on MutableList.
        MutableList<Person> peopleWithoutCats = this.people.rejectWith(Person::hasPet, PetType.CAT);  // this.people...

        Verify.assertSize(6, peopleWithoutCats);
    }
}
