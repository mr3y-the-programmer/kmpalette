Pod::Spec.new do |spec|
    spec.name                     = 'composeApp'
    spec.version                  = '1.0.0'
    spec.homepage                 = 'empty'
    spec.source                   = { :http=> ''}
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = 'Compose application framework'
    spec.vendored_frameworks      = 'build/cocoapods/framework/ComposeApp.framework'
    spec.libraries                = 'c++'
    spec.ios.deployment_target = '11.0'
                
                
    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':demo:composeApp',
        'PRODUCT_MODULE_NAME' => 'ComposeApp',
    }
                
    spec.script_phases = [
        {
            :name => 'Build composeApp',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :script => <<-SCRIPT
                if [ "YES" = "$OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED" ]; then
                  echo "Skipping Gradle build task invocation due to OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED environment variable set to \"YES\""
                  exit 0
                fi
                set -ev
                REPO_ROOT="$PODS_TARGET_SRCROOT"
                "$REPO_ROOT/../../gradlew" -p "$REPO_ROOT" $KOTLIN_PROJECT_PATH:syncFramework \
                    -Pkotlin.native.cocoapods.platform=$PLATFORM_NAME \
                    -Pkotlin.native.cocoapods.archs="$ARCHS" \
                    -Pkotlin.native.cocoapods.configuration="$CONFIGURATION"
            SCRIPT
        }
    ]
    spec.resources = ['build/generated/libres/apple/libres-bundles']
end