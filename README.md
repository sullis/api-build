# api-lint
Runs a set of tests against an API defined in apidoc to ensure consistency

## Installation

  curl https://s3.amazonaws.com/io.flow.aws-s3-public/util/api-lint/api-lint.jar > ~/api-lint.jar
  java -jar ~/api-lint.jar flow/carrier flow/user

## running locally

api-lint needs to access apidoc and requires an API Token:

  1. Goto http://apidoc.me/tokens/ and create a token

  2. Create the ~/.apidoc/config file - see https://github.com/mbryzek/apidoc-cli


## publishing jar file

We are using one-jar to publish (see https://github.com/sbt/sbt-onejar)

    sbt

    one-jar

## Running from the command line:

    java -jar /web/api-lint/target/scala-2.11/api-lint_2.11-0.0.1-one-jar.jar flow/user

To specify a specific APIDOC Profile:

    APIDOC_PROFILE=xxx java -jar /web/api-lint/target/scala-2.11/api-lint_2.11-0.0.1-one-jar.jar flow/user

The default behavior is to use the default apidoc profile.

