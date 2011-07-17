//
//  User.m
//  Nellodee
//
//  Created by Ada Hopper on 11/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "User.h"


@implementation User

@synthesize responseData;

-(BOOL) meService{
	NSLog(@" ---- me Service ---");
	NSMutableURLRequest *request = [NSMutableURLRequest
									requestWithURL:[NSURL URLWithString:@"http://sakai3-demo.uits.indiana.edu:8080/system/me"]];
	[request setHTTPMethod: @"GET"];
	[request setHTTPShouldHandleCookies:NO];
	[request addValue:@"http://sakai3-demo.uits.indiana.edu:8080/system/me" forHTTPHeaderField:@"Referer"];
	NSArray* cookies = [[NSHTTPCookieStorage sharedHTTPCookieStorage]
						cookiesForURL:[NSURL URLWithString:@"http://sakai3-demo.uits.indiana.edu:8080"]];
	NSDictionary* headers = [NSHTTPCookie requestHeaderFieldsWithCookies:cookies];
	
	if(cookies != nil){
		[request setAllHTTPHeaderFields:headers];
	}
	else{
		NSLog(@"Error: user no authenticated");
	}
	
	
	NSURLConnection *connection = [[NSURLConnection alloc]
								   initWithRequest:request
								   delegate:self
								   startImmediately:NO];
	[connection scheduleInRunLoop:[NSRunLoop currentRunLoop]
						  forMode:NSRunLoopCommonModes];
	[connection start];

	
	//[[NSURLConnection alloc] initWithRequest:request delegate:self];  
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
		/*self.currentCookies =[NSHTTPCookie 
							  cookiesWithResponseHeaderFields:[response allHeaderFields]
							  forURL:[NSURL URLWithString:@"http://10.211.55.2:8080"]];
		*/
		// Add the array of cookies in the shared cookie storage instance 
		/*[[NSHTTPCookieStorage sharedHTTPCookieStorage]
		 setCookies:self.currentCookies
		 forURL:[NSURL URLWithString:@"http://10.211.55.2:8080"]
		 mainDocumentURL:nil];
		*/
		/*for (NSHTTPCookie* cookie in self.currentCookies)
			NSLog(@"\nName: %@\nValue: %@\nExpires: %@", [cookie name], [cookie value], [cookie expiresDate]);
		*/
		
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


@end
