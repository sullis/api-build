package io.flow.lint

import io.apibuilder.spec.v0.models._
import org.scalatest.{FunSpec, Matchers}

class UnionTypesHaveCommonDiscriminatorSpec extends FunSpec with Matchers {

  private[this] val linter = linters.UnionTypesHaveCommonDiscriminator

  def buildService(
    typeName: String,
    discriminator: Option[String]
  ): Service = {
    Services.Base.copy(
      unions = Seq(
        Services.buildUnion(
          name = typeName,
          discriminator = discriminator,
          types = Seq(
            Services.buildUnionType("string"),
            Services.buildUnionType("uuid")
          )
        )
      )
    )
  }

  it("with no discriminator") {
    linter.validate(buildService("expandable_user", None)) should be (
      Seq("Union expandable_user: Must have a discriminator with value 'discriminator'")
    )
  }

  it("with invalid discriminator") {
    linter.validate(buildService("expandable_user", Some("foo"))) should be (
      Seq("Union expandable_user: Discriminator must have value 'discriminator' and not 'foo'")
    )
  }

  it("with valid discriminator") {
    linter.validate(buildService("expandable_user", Some("discriminator"))) should be (Nil)
  }

  it("union types that end in _error must have a discriminator named 'code'") {
    linter.validate(buildService("user_error", None)) should be (
      Seq("Union user_error: Must have a discriminator with value 'code'")
    )
  }

  it("union types that end in _error with invalid discriminator") {
    linter.validate(buildService("user_error", Some("foo"))) should be (
      Seq("Union user_error: Discriminator must have value 'code' and not 'foo'")
    )
  }

  it("union types that end in _error with valid discriminator") {
    linter.validate(buildService("user_error", Some("code"))) should be (Nil)
  }

}
