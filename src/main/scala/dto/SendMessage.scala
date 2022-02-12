package dto

class SendMessage(message: String, isExceptionPresent: Boolean = false, isSuccessfullyProcessed: Boolean = false) {

  var msg = message
  var isException = isExceptionPresent
  var isProcessed = isSuccessfullyProcessed
}
