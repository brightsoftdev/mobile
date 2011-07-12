//
//  Authorization.m
//  Nellodee
//
//  Created by Ada Hopper on 24/06/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "Authorization.h"
#import "SBJson.h"


@implementation Authorization

@synthesize responseData,currentCookies;



- (BOOL) formBasedAuth :(NSString*)username :(NSString*) password{
	NSLog(@"\nUsername: %@ - Password: %@ ", username, password);
	NSLog(@" formBasedAuth ");
	
	//Formating post data. 
	NSString *post = [NSString 
					   stringWithFormat:@"sakaiauth:un=%@&sakaiauth:pw=%@&sakaiauth:login=1&_charset_=utf-8",username,password];
	NSData *postData = [post dataUsingEncoding:NSASCIIStringEncoding allowLossyConversion:YES];
	NSString *postLength = [NSString stringWithFormat:@"%d", [postData length]];


	//Creating the request
	NSMutableURLRequest *request = [NSMutableURLRequest 
									requestWithURL:[NSURL URLWithString:@"http://10.211.55.2:8080/system/sling/formlogin"]];
	//NSMutableURLRequest *request = [NSMutableURLRequest 
	//								requestWithURL:[NSURL URLWithString:@"http://sakai3-demo.uits.indiana.edu:8080/system/sling/formlogin"]];
	[request setHTTPMethod:@"POST"];
	[request addValue:@"http://10.211.55.2:8080/system/sling/formlogin" forHTTPHeaderField:@"Referer"];
	[request setValue:postLength forHTTPHeaderField:@"Content-Length"];
	[request setValue:@"application/x-www-form-urlencoded" forHTTPHeaderField:@"Content-Type"];
	[request setHTTPBody:postData];
	[request setHTTPShouldHandleCookies:YES];


	NSURLResponse *response =[[NSURLResponse alloc]init];
	NSError *error = nil;
	
	//WARNING (TO MYSELF): I SHOULD IMPLEMENT THE DELEGATE METHODS.
	//Calling the web service
	@try {
		
		NSData * data=[NSURLConnection sendSynchronousRequest:request returningResponse:&response error:&error]; 
		NSMutableString *string = [[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding];
		NSLog(@"Response: ", string);
		NSHTTPURLResponse *httpResponse = (NSHTTPURLResponse *)response;
		NSInteger status = [httpResponse statusCode];
		NSLog(@"Status: %d",status);
		if (status == 200) {
			// Get an array with all the cookies 
			self.currentCookies =[NSHTTPCookie cookiesWithResponseHeaderFields:[httpResponse allHeaderFields]
																		forURL:[NSURL URLWithString:@"http://10.211.55.2:8080"]];
			// Add the array of cookies in the shared cookie storage instance 
			[[NSHTTPCookieStorage sharedHTTPCookieStorage]
			 setCookies:self.currentCookies
			 forURL:[NSURL URLWithString:@"http://10.211.55.2:8080"]
			 mainDocumentURL:nil];
			
			for (NSHTTPCookie* cookie in self.currentCookies)
				NSLog(@"\nName: %@\nValue: %@\nExpires: %@", [cookie name], [cookie value], [cookie expiresDate]);

			
			return YES;
		}
		else{
			return NO;
		}
		
	}
	@catch (NSException * e) {
		NSLog(@"Caught %@", [e name]);
		return NO;
	}
	
	return NO;	
} 

/*

- (BOOL) formBasedAuth:(NSString*)username :(NSString*) password{
	NSLog(@"--- formBasedAuth ---");
	NSLog(@"\nUsername: %@ - Password: %@ ", username, password);
	
	//Formating post data. 
	NSString *post = [NSString 
					  stringWithFormat:@"sakaiauth:un=%@&sakaiauth:pw=%@&sakaiauth:login=1&_charset_=utf-8",username,password];
	NSData *postData = [post dataUsingEncoding:NSUTF8StringEncoding allowLossyConversion:YES];
	NSString *postLength = [NSString stringWithFormat:@"%d", [postData length]];

	responseData = [[NSMutableData data] retain];  
	NSMutableURLRequest *request = [NSMutableURLRequest
							 requestWithURL:[NSURL URLWithString:@"http://10.211.55.2:8080/system/sling/formlogin"]];
	[request setHTTPMethod:@"POST"];
	[request addValue:@"http://10.211.55.2:8080/system/sling/formlogin" forHTTPHeaderField:@"Referer"];
	[request setValue:postLength forHTTPHeaderField:@"Content-Length"];
	[request setValue:@"application/x-www-form-urlencoded" forHTTPHeaderField:@"Content-Type"];
	[request setHTTPBody:postData];
	//[request setHTTPShouldHandleCookies:YES];

   NSURLConnection * _connection = [[NSURLConnection alloc] initWithRequest:request delegate:self startImmediately:YES];  
 
	NSPort* port = [NSPort port];
	NSRunLoop* rl = [NSRunLoop currentRunLoop]; // Get the runloop
	[rl addPort:port forMode:NSDefaultRunLoopMode];
	[_connection scheduleInRunLoop:rl forMode:NSDefaultRunLoopMode];
	[_connection start];
	[rl run];
 
	return YES;
} 



- (void)connection:(NSURLConnection *)connection didReceiveResponse:(NSURLResponse *)response {  
	NSLog(@"didReceiveResponse");
	NSHTTPURLResponse *httpResponse = (NSHTTPURLResponse *)response;
	if ([httpResponse statusCode] >= 400) {
		NSLog(@"Remote url returned error %d %@",[httpResponse statusCode],[NSHTTPURLResponse localizedStringForStatusCode:[httpResponse statusCode]]);
	} else {
		NSLog(@"It is working. Status: %d %@",[httpResponse statusCode],[NSHTTPURLResponse localizedStringForStatusCode:[httpResponse statusCode]]);
		//Get Cookies
		self.currentCookies =[NSHTTPCookie 
							  cookiesWithResponseHeaderFields:[response allHeaderFields]
							  forURL:[NSURL URLWithString:@"http://10.211.55.2:8080"]];
		
		// Add the array of cookies in the shared cookie storage instance 
		[[NSHTTPCookieStorage sharedHTTPCookieStorage]
		 setCookies:self.currentCookies
		 forURL:[NSURL URLWithString:@"http://10.211.55.2:8080"]
		 mainDocumentURL:nil];
		
		for (NSHTTPCookie* cookie in self.currentCookies)
			NSLog(@"\nName: %@\nValue: %@\nExpires: %@", [cookie name], [cookie value], [cookie expiresDate]);
		

		 }
    [responseData setLength:0];  
}  

- (void)connection:(NSURLConnection *)connection didReceiveData:(NSData *)data {  
	NSLog(@"didReceiveData");
	NSString *theResponseString = [[[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding] autorelease];
	NSLog(theResponseString);
    [responseData appendData:data];  
}  

- (void)connection:(NSURLConnection *)connection didFailWithError:(NSError *)error {  
	NSLog(@"Connection failed: %@", [error description]);
}  

- (void)connectionDidFinishLoading:(NSURLConnection *)connection {  
	NSLog(@"connectionDidFinishLoading");

    [connection release];  
    [responseData release];  
	
}  

*/



@end

/* NOTES:
 
 How to send JSON object:

 NSDictionary *requestData = [NSDictionary dictionaryWithObjectsAndKeys:
 @"sakaiauth:un", username,
 @"sakaiauth:pw", password,
 @"sakaiauth:login", @"1",
 @"_charset_", @"utf-8",
 ni
 -> JSON Object
 NSString *jsonString = [requestData JSONRepresentation];
 NSData *jsonData = [jsonString dataUsingEncoding:NSUTF8StringEncoding];
 NSLog(@"%@", jsonString);

 -> Sending JSON Object
 [request setValue:jsonString forHTTPHeaderField:@"json"];
 [request setValue:@"application/json" forHTTPHeaderField:@"Content-type"];
 [request setHTTPBody:jsonData];
 
*/