/*
 * Copyright (c) 2021 D4L data4life gGmbH / All rights reserved.
 *
 * D4L owns all legal rights, title and interest in and to the Software Development Kit ("SDK"),
 * including any intellectual property rights that subsist in the SDK.
 *
 * The SDK and its documentation may be accessed and used for viewing/review purposes only.
 * Any usage of the SDK for other purposes, including usage for the development of
 * applications/third-party applications shall require the conclusion of a license agreement
 * between you and D4L.
 *
 * If you are interested in licensing the SDK for your own applications/third-party
 * applications and/or if you’d like to contribute to the development of the SDK, please
 * contact D4L by email to help@data4life.care.
 */

package care.data4life.sdk.securestore

import android.content.Context
import care.data4life.sdk.securestore.storage.AndroidSharedPreferenceStorage

actual class SecureStoreStorage @JvmOverloads constructor(
    context: Context,
    private val storage: SecureStoreContract.Storage = AndroidSharedPreferenceStorage(
        context,
        PREFERENCE_NAME
    )
) : SecureStoreContract.Storage {

    override fun addData(alias: String, data: CharArray) {
        storage.addData(alias, data)
    }

    override fun removeData(alias: String) {
        storage.removeData(alias)
    }

    override fun containsData(alias: String): Boolean {
        return storage.containsData(alias)
    }

    override fun getData(alias: String): CharArray? {
        return storage.getData(alias)
    }

    override fun clear() {
        storage.clear()
    }

    companion object {
        internal const val PREFERENCE_NAME = BuildConfig.LIBRARY_PACKAGE_NAME + ".storage"
    }
}
