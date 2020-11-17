# Naming Conventions

## Packages

- lowercase *not camel case*
- unique
- reverse domain name is prefixed. replace `-` to `_`; starting numbers to `_`; java keyword to start with `_`.

e.g.: 

- Switch.supplier.com >>>> com.supplier._switch
- 1world.com >>>> com._world
- experts-exchange.com >>>> com.experts_exchange
- TheTelegraph.org >>> org.thetelegraph

## Classes

- camelcase starting with caps
- should be nouns

e.g.:

- LinkedList
- GearBox
- Main

## Interface

- camelcase starting with caps
- name should be based on the classes that will implement this interface

e.g.:

- List
- Comparable
- Serializable

## Methods

- camel case, starts with lower case
- should be verbs
- based on the action performed by the method, and data returned.

e.g.:

- size()
- getName()
- addPlayer()

## Variables

- camel case, starts with lower case
- meaningful, eg singular or plural

e.g.:

- teams // if array or list
- team // singular obj
- teamName

## Constants

- snake case
- caps
- should use the keyword final

e.g.:

- MAX_INT
- PI
- SEVERITY_ERROR

## Type parameter

- single letter
- capital

e.g.:

- E //element; used in java framework
- K // key
- V //Value
- T //Type
- S, U, V // 2nd, 3rd, or 4th type