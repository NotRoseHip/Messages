package org.fossify.messages.models

import org.fossify.messages.databinding.ItemMessageBinding

/**
 * Thread item representations for the main thread recyclerview. [Message] is also a [ThreadItem]
 */
sealed class ThreadItem {
    data class ThreadLoading(val id: Long) : ThreadItem()
    data class ThreadDateTime(val date: Int, val simID: String) : ThreadItem()
    data class ThreadError(val messageId: Long, val messageText: String) : ThreadItem()
    data class ThreadSent(val messageId: Long, val delivered: Boolean) : ThreadItem()
    data class ThreadSending(val messageId: Long) : ThreadItem()
    data class ThreadScan(val item: ItemMessageBinding) : ThreadItem()
}
