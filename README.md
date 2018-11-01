<a title="Gitter" href="https://gitter.im/DominoKit/gwt-joda-money"><img src="https://badges.gitter.im/Join%20Chat.svg"></a>
[![Build Status](https://travis-ci.org/DominoKit/gwt-joda-money.svg?branch=master)](https://travis-ci.org/DominoKit/gwt-joda-money)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.dominokit/gwt-joda-money/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.dominokit/gwt-joda-money)
![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/org.dominokit/gwt-joda-money.svg)


# GWT JODA Money

A wrapper project for Joda Money to work with GWT.

## Setup

### Maven dependency

```xml
<dependency>
  <groupId>org.dominokit</groupId>
  <artifactId>gwt-joda-money</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

> To use the snapshot version without building locally, configure the snapshot repository
```xml
<repository>
   <id>sonatype-snapshots-repo</id>
   <url>https://oss.sonatype.org/content/repositories/snapshots</url>
   <snapshots>
      <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
      <checksumPolicy>fail</checksumPolicy>
   </snapshots>
</repository>
```

### GWT module inheritance
```xml
<inherits name="org.dominokit.joda.Money"/>
```

