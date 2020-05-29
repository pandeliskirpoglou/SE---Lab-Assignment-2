**Mockito Dependency**
```
	<dependency>
		<groupId>org.mockito</groupId>
		<artifactId>mockito-core</artifactId>
		<version>2.27.0</version>
		<scope>test</scope>
	</dependency>
```

**Jacoco plugin**
```
	<plugin>
		<groupId>org.jacoco</groupId>
		<artifactId>jacoco-maven-plugin</artifactId>
		<version>0.8.3</version>
		<executions>
			<execution>
				<id>prepare-agent</id>
				<goals>
					<goal>prepare-agent</goal>
				</goals>
			</execution>
		</executions>
	</plugin>

```

**Coveralls plugin**
```
	<plugin>
		<groupId>org.eluder.coveralls</groupId>
		<artifactId>coveralls-maven-plugin</artifactId>
		<version>4.3.0</version>
	</plugin>
```