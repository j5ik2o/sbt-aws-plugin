lazy val root = (project in sbt.file(".")).
  enablePlugins(SbtAwsPlugin).
  settings(
    version := "0.1",
    scalaVersion := "2.10.5",
    AwsKeys.region in AwsKeys.aws := com.amazonaws.regions.Regions.AP_NORTHEAST_1,
    AwsKeys.S3Keys.s3BucketName in AwsKeys.aws := "cw-s3-test",
    AwsKeys.S3Keys.s3Key in AwsKeys.aws := "test",
    AwsKeys.S3Keys.s3File in AwsKeys.aws := sbt.file("build.sbt")
  )
