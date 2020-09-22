# grasp-reporting

This repo is a place to experiment with different reporting and logging frameworks to figure out which ones are best suited for the use case

## Report portal

To update to latest version of report portal, get the latest docker-compose
.yml file

```zsh
curl https://raw.githubusercontent.com/reportportal/reportportal/master/docker-compose.yml -o docker-compose.yml
```

Then, run below command to spin up containers

```zsh
# --remove-orphans removes the orphan containers (good practice)
docker-compose -f docker-compose.yml -p reportportal up -d --force-recreate --remove-orphans
```

You can then access report portal via 

```text
http://localhost:8080/ui/
```

and login using default id and passwords (change them)

```zsh
default\1q2w3e
or
superadmin\erebus
```

Run all the tests via

```zsh
./gradlew clean runTests -Dtag="all"
```

## References

- [Read this article from Baeldung on logback](https://www.baeldung.com/logback)
- [README on logger-java-logback integration](https://github.com/reportportal/logger-java-logback)