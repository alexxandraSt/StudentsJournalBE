//package com.studensJournal.utils.email;
//
//
//public class HtmlEmailPattern {
//
//    public static String getRegisterLetter(String email) {
//        return "<table style=\"max-width:100%;\"><tbody><tr style=\"max-width:100%;\"><td style=\"max-width:100%;\" class=\"mailContainer\"><div style=\"overflow-x:hidden;overflow-y:auto;\" id=\"message_body\">\n" +
//                "<div class=\"es-wrapper-color\" style=\"background-color:#F5F6FA\">\n" +
//                "    \n" +
//                "    </div><table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#f3f3f3\" style=\"border-bottom:1px solid #E8E8E8\" id=\"emailInfo\">\n" +
//                "</table><table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top\">\n" +
//                "        <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "            <td class=\"es-m-margin\" valign=\"top\" style=\"padding:0;Margin:0\">\n" +
//                "                <table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
//                "                    <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                        <td style=\"padding:0;Margin:0;background-color:transparent\" bgcolor=\"transparent\" align=\"center\">\n" +
//                "                            <table class=\"es-header-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#FFFFFF\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\">\n" +
//                "                                <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                                    <td class=\"es-m-p15b\" align=\"left\" style=\"padding:0;Margin:0;padding-top:30px;padding-bottom:30px\">\n" +
//                "                                        <table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
//                "                                            <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                                                <td class=\"es-m-p0r\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\">\n" +
//                "                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
//                "                                                        <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                                                            <td align=\"center\" class=\"es-m-txt-c\" style=\"padding:0;Margin:0;font-size:0px\"><a href=\"http://dashboard.nomad-family.xyz\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:verdana, geneva, sans-serif;font-size:14px;text-decoration:underline;color:#1376C8\" target=\"_blank\"><img src=\"http://dashboard.nomad-family.xyz/img/logo/\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"169\"></a></td>\n" +
//                "                                                        </tr>\n" +
//                "                                                        </tbody></table></td>\n" +
//                "                                            </tr>\n" +
//                "                                            </tbody></table></td>\n" +
//                "                                </tr>\n" +
//                "                                </tbody></table></td>\n" +
//                "                    </tr>\n" +
//                "                    </tbody></table>\n" +
//                "                <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
//                "                    <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
//                "                            <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;border-top:1px solid #F6F7FF;border-right:1px solid #F6F7FF;border-left:1px solid #F6F7FF;width:600px;border-bottom:1px solid #F6F7FF\">\n" +
//                "                                <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                                    <td align=\"left\" style=\"padding:0;Margin:0;padding-top:30px;padding-left:30px;padding-right:30px\">\n" +
//                "                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
//                "                                            <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                                                <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:538px\">\n" +
//                "                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
//                "                                                        <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                                                            <td align=\"left\" style=\"padding:0;Margin:0;padding-bottom:30px\"><h3 style=\"Margin:0;line-height:33px;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:22px;font-style:normal;font-weight:normal;color:#333333;text-align:center\">Nomad Family personal account registration</h3></td>\n" +
//                "                                                        </tr>\n" +
//                "                                                        <tr style=\"border-collapse:collapse\">\n" +
//                "                                                            <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#777777\">Dear user,</p></td>\n" +
//                "                                                        </tr>\n" +
//                "                                                        <tr style=\"border-collapse:collapse\">\n" +
//                "                                                            <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#777777\">You have successfully registered on the Nomad Family personal account</p></td>\n" +
//                "                                                        </tr>\n" +
//                "                                                        \n" +
//                "                                                        \n" +
//                "                                                        </tbody></table></td>\n" +
//                "                                            </tr>\n" +
//                "                                            </tbody></table></td>\n" +
//                "                                </tr>\n" +
//                "                                <tr style=\"border-collapse:collapse\">\n" +
//                "                                    <td align=\"left\" style=\"Margin:0;padding-top:5px;padding-bottom:30px;padding-left:30px;padding-right:30px\">\n" +
//                "                                        <table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
//                "                                            <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                                                <td align=\"left\" style=\"padding:0;Margin:0;width:538px\">\n" +
//                "                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;background:linear-gradient(44.1deg,#191234 15.34%,#2b1d60 72.83%);border-radius:15px\" bgcolor=\"#F5F6FA\">\n" +
//                "                                                        <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                                                            <td align=\"center\" style=\"padding:0;Margin:0;padding-left:5px;padding-right:5px;padding-top:15px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:13px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:20px;color:#898CAB\">If you didn't initiate this action, contact support service immediately <a style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:13px;text-decoration:none;color:#863982\" href=\"mailto:support@nomad-family.xyz\" target=\"_blank\">support@nomad-family.xyz</a></p></td>\n" +
//                "                                                        </tr>\n" +
//                "                                                        <tr style=\"border-collapse:collapse\">\n" +
//                "                                                            <td align=\"center\" style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:10px;padding-bottom:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:13px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:20px;color:#898CAB\">This email has been sent to<a style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:13px;text-decoration:none;color:#863982\" href=\"\" target=\"_blank\">&nbsp;"+ email + "</a></p></td>\n" +
//                "                                                        </tr>\n" +
//                "                                                        <tr style=\"border-collapse:collapse\">\n" +
//                "                                                            <td align=\"center\" style=\"padding:0;Margin:0;padding-left:5px;padding-right:5px;padding-bottom:15px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:13px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:20px;color:#898CAB\">Copyright © 2021 Nomad Family</p></td>\n" +
//                "                                                        </tr>\n" +
//                "                                                        </tbody></table></td>\n" +
//                "                                            </tr>\n" +
//                "                                            </tbody></table></td>\n" +
//                "                                </tr>\n" +
//                "                                </tbody></table></td>\n" +
//                "                    </tr>\n" +
//                "                    </tbody></table>\n" +
//                "                <table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
//                "                    <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                        <td style=\"padding:0;Margin:0;background-color:transparent\" bgcolor=\"transparent\" align=\"center\">\n" +
//                "                            <table class=\"es-header-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#FFFFFF\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\">\n" +
//                "                                <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                                    <td class=\"es-m-p15b\" align=\"left\" style=\"padding:0;Margin:0;padding-top:30px;padding-bottom:30px\">\n" +
//                "                                        <table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
//                "                                            <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                                                <td class=\"es-m-p0r\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\">\n" +
//                "                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
//                "                                                        <tbody><tr style=\"border-collapse:collapse\">\n" +
//                "                                                            <td align=\"center\" style=\"padding:0;Margin:0;display:none\"></td>\n" +
//                "                                                        </tr>\n" +
//                "                                                        </tbody></table></td>\n" +
//                "                                            </tr>\n" +
//                "                                            </tbody></table></td>\n" +
//                "                                </tr>\n" +
//                "                                </tbody></table></td>\n" +
//                "                    </tr>\n" +
//                "                    </tbody></table></td>\n" +
//                "        </tr>\n" +
//                "        </tbody></table>\n" +
//                "</div>\n" +
//                "\n" +
//                "</td></tr></tbody></table>";
//    }
//}
