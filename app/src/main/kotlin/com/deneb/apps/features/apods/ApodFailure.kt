package com.deneb.apps.features.apods

import com.deneb.apps.core.exception.Failure.FeatureFailure

class ApodFailure {
    class ListNotAvailable: FeatureFailure()
    class NonExistentApod: FeatureFailure()
}